package com.example.a31agostobasicactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.a31agostobasicactivity.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var txt_numero1: EditText
    private lateinit var txt_numero2: EditText
    private lateinit var txt_respuesta: EditText

    private lateinit var rad_butt_sum: RadioButton
    private lateinit var rad_butt_res: RadioButton
    private lateinit var rad_butt_mul: RadioButton
    private lateinit var rad_butt_div: RadioButton

    private lateinit var rad_group: RadioGroup


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        // relacionando con binding(por que es un fragment) las variables creadas anteriormente
        txt_numero1 = binding.editTextNumero1
        txt_numero2 = binding.editTextNumero2
        txt_respuesta = binding.editTextResultado

        rad_butt_sum =  binding.radioButtonSuma
        rad_butt_res =  binding.radioButtonResta
        rad_butt_mul =  binding.radioButtonMultiplicar
        rad_butt_div =  binding.radioButtonDividir

        rad_group = binding.radioGroupOperaciones


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonCalcular.setOnClickListener{
            if (rad_butt_sum.isChecked){
                //sumar
                sum()
            } else if (rad_butt_res.isChecked){
                //restar
                res()
            } else if (rad_butt_mul.isChecked){
                //multiplicar
                mul()
            } else if (rad_butt_div.isChecked){
                //dividir
                div()
            }
        }
    }

    fun print(mensaje: String) {
        Toast.makeText(this.context, mensaje, Toast.LENGTH_SHORT).show()
    }

    fun sum(){
        var numero1: Double = txt_numero1.text.toString().toDouble()
        var numero2: Double = txt_numero2.text.toString().toDouble()

        var resultado: Double = numero1 + numero2 //tipo double
        txt_respuesta.setText(resultado.toString())
    }
    fun res(){
        var numero1: Double = txt_numero1.text.toString().toDouble()
        var numero2: Double = txt_numero2.text.toString().toDouble()

        var resultado: Double = numero1 - numero2 //tipo double
        txt_respuesta.setText(resultado.toString())
    }
    fun mul(){
        var numero1: Double = txt_numero1.text.toString().toDouble()
        var numero2: Double = txt_numero2.text.toString().toDouble()

        var resultado: Double = numero1 * numero2 //tipo double
        txt_respuesta.setText(resultado.toString())
    }
    fun div(){
        var numero1: Double = txt_numero1.text.toString().toDouble()
        var numero2: Double = txt_numero2.text.toString().toDouble()

        var resultado: Double = numero1 / numero2 //tipo double
        txt_respuesta.setText(resultado.toString())
    }

    //hacer lo mismo con checkbox

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}