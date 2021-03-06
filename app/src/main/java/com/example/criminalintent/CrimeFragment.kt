package com.example.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.criminalintent.databinding.FragmentCrimeBinding

class CrimeFragment : Fragment() {

    private lateinit var crime: Crime
    private lateinit var crimeEt:EditText
    private lateinit var dateBtn:Button
    private lateinit var solvedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_crime, container, false)

        crimeEt = view.findViewById(R.id.crime_title_Et) as EditText
        dateBtn = view.findViewById(R.id.crime_date_Btn) as Button

        dateBtn.apply {
            text = crime.date.toString()
            isEnabled = false
        }
        solvedCheckBox = view.findViewById(R.id.crime_solved)

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher:TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime.title = s.toString()

            }

            override fun afterTextChanged(s: Editable?) {

            }

        }

        solvedCheckBox.apply {
            setOnCheckedChangeListener { buttonView, isChecked -> crime.isSolved = isChecked  }
        }
    }

}