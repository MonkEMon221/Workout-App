package com.vishesh.workoutapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vishesh.workoutapp.databinding.ActivityBmiactivityBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    companion object {
        private const val METRIC_UNIT_VIEW = "METRIC_UNIT_VIEW"
        private const val US_UNIT_VIEW = "US_UNIT_VIEW"
    }

    private var currentVisibleView: String = METRIC_UNIT_VIEW

    private lateinit var binding: ActivityBmiactivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarBMI)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Calculate BMI"
        }

        binding.toolbarBMI.setNavigationOnClickListener {
            onBackPressed()
        }

        makeVisibleMetricUnitsView()

        binding.rgUnits.setOnCheckedChangeListener { _, checkedId: Int ->
            if (checkedId == R.id.rbMetricsUnit) {
                makeVisibleMetricUnitsView()
            } else {
                makeVisibleUSUnitsView()
            }
        }

        binding.btnCalculateUnit.setOnClickListener {
            calculateUnits()
        }
    }

    private fun makeVisibleMetricUnitsView() {
        currentVisibleView = METRIC_UNIT_VIEW
        binding.tilMetricUnitWeight.visibility = View.VISIBLE
        binding.tilMetricUnitHeight.visibility = View.VISIBLE
        binding.tilMetricUnitHeightFeet.visibility = View.INVISIBLE
        binding.tilMetricUnitHeightInch.visibility = View.INVISIBLE
        binding.tilUSUnitWeight.visibility = View.INVISIBLE

        binding.ETMetricUnitHeight.text!!.clear()
        binding.ETMetricUnitWeight.text!!.clear()

        binding.llDisplayBMIResult.visibility = View.INVISIBLE
    }

    private fun makeVisibleUSUnitsView() {
        currentVisibleView = US_UNIT_VIEW
        binding.tilMetricUnitWeight.visibility = View.INVISIBLE
        binding.tilMetricUnitHeight.visibility = View.INVISIBLE
        binding.tilMetricUnitHeightFeet.visibility = View.VISIBLE
        binding.tilMetricUnitHeightInch.visibility = View.VISIBLE
        binding.tilUSUnitWeight.visibility = View.VISIBLE

        binding.ETMetricUnitHeightFeet.text!!.clear()
        binding.ETMetricUnitHeightInch.text!!.clear()
        binding.ETUSUnitWeight.text!!.clear()

        binding.llDisplayBMIResult.visibility = View.INVISIBLE
    }

    private fun displayBMIResult(bmi: Float) {
        val bmiLabel: String
        val bmiDescription: String

        if (bmi.compareTo(15f) <= 0) {
            bmiLabel = "Very Severely UnderWeight"
            bmiDescription = "Oops you really need to take care of yourself! Eat More"
        } else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0) {
            bmiLabel = "Severely UnderWeight"
            bmiDescription = "Oops you really need to take care of yourself! Eat More"
        } else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0) {
            bmiLabel = "UnderWeight"
            bmiDescription = "Oops you really need to take care of yourself! Eat More"
        } else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0) {
            bmiLabel = "Normal"
            bmiDescription = "Congratulations! You Are In Good Shape"
        } else if (bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0) {
            bmiLabel = "Overweight"
            bmiDescription = "Oops you really need to take care of yourself! Workout More"
        } else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0) {
            bmiLabel = "Obese Class | Moderately Obese"
            bmiDescription = "Oops you really need to take care of yourself! Workout More"
        } else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0) {
            bmiLabel = "Obese Class || (Severely obese)"
            bmiDescription = "Oops you really need to take care of yourself!Act Now!"
        } else {
            bmiLabel = "Obese Class ||| (Very severely obese)"
            bmiDescription = "Oops you really need to take care of yourself! Act Now!"
        }

        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        binding.llDisplayBMIResult.visibility = View.VISIBLE
        binding.tvBMIValue.text = bmiValue
        binding.tvBMIType.text = bmiLabel
        binding.tvBMIDescription.text = bmiDescription
    }

    private fun validateMetricUnits(): Boolean {
        var valid = true
        if (binding.ETMetricUnitWeight.text.toString().isEmpty()) {
            valid = false
        } else if (binding.ETMetricUnitHeight.text.toString().isEmpty()) {
            valid = false
        }

        return valid
    }

    private fun calculateUnits() {
        if (currentVisibleView == METRIC_UNIT_VIEW) {
            if (validateMetricUnits()) {
                val heightValue: Float = binding.ETMetricUnitHeight.text.toString().toFloat() / 100
                val weightValue: Float = binding.ETMetricUnitWeight.text.toString().toFloat()
                val bmi = weightValue / (heightValue * heightValue)

                displayBMIResult(bmi)

            } else {
                Toast.makeText(
                    this,
                    "Please Enter Valid Values",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            if (validateUSUnits()) {
                val USUnitHeightValueFeet: String =
                    binding.ETMetricUnitHeightFeet.text.toString()
                val USUnitHeightValueInch: String =
                    binding.ETMetricUnitHeightInch.text.toString()
                val USUnitWeight: Float =
                    binding.ETUSUnitWeight.text.toString().toFloat()
                val heightValue =
                    USUnitHeightValueInch.toFloat() + USUnitHeightValueFeet.toFloat() * 12
                val bmi = 703 * (USUnitWeight / (heightValue * heightValue))
                displayBMIResult(bmi)
            } else {
                Toast.makeText(
                    this,
                    "Please Enter Valid Values",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun validateUSUnits(): Boolean {
        var valid = true
        when {
            binding.ETUSUnitWeight.text.toString().isEmpty() -> {
                valid = false
            }

            binding.ETMetricUnitHeightFeet.text.toString().isEmpty() -> {
                valid = false
            }
            binding.ETMetricUnitHeightInch.text.toString().isEmpty() -> {
                valid = false
            }

        }

        return valid

    }

}