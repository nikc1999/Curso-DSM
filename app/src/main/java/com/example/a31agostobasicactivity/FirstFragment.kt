package com.example.a31agostobasicactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
    private lateinit var txt_respuesta: EditText  //textBox respuesta
    private var mensaje_respuesta: String = ""

    private lateinit var rad_butt_sum: RadioButton
    private lateinit var rad_butt_res: RadioButton
    private lateinit var rad_butt_mul: RadioButton
    private lateinit var rad_butt_div: RadioButton

    private lateinit var rad_group: RadioGroup

    private lateinit var checkBox_sum: CheckBox
    private lateinit var checkBox_res: CheckBox
    private lateinit var checkBox_mul: CheckBox
    private lateinit var checkBox_div: CheckBox

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

        checkBox_sum = binding.checkBoxSuma
        checkBox_res = binding.checkBoxResta
        checkBox_mul = binding.checkBoxMultiplicacion
        checkBox_div = binding.checkBoxDivision


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonCalcular.setOnClickListener{
            var textoNumero1: String =  txt_numero1.text.toString()
            var textoNumero2: String =  txt_numero2.text.toString()

            if ((!rad_butt_sum.isChecked and !rad_butt_res.isChecked and !rad_butt_mul.isChecked
                and !rad_butt_div.isChecked and !checkBox_sum.isChecked and !checkBox_res.isChecked
                and !checkBox_mul.isChecked and !checkBox_div.isChecked) or (textoNumero1 == "") or (textoNumero2 == "") ){
                print("Ingrese los numeros y Seleccione la operacion a realizar")
            }

            if (rad_butt_sum.isChecked or checkBox_sum.isChecked){
                //sumar
                mensaje_respuesta += "Suma: " + sum() + "\n"
                txt_respuesta.setText(mensaje_respuesta)
            }
            if (rad_butt_res.isChecked or checkBox_res.isChecked){
                //restar
                mensaje_respuesta += "Resta: " + res() + "\n"
                txt_respuesta.setText(mensaje_respuesta)
            }
            if (rad_butt_mul.isChecked or checkBox_mul.isChecked){
                //multiplicar
                mensaje_respuesta += "Multiplicacion: " + mul() + "\n"
                txt_respuesta.setText(mensaje_respuesta)
            }
            if (rad_butt_div.isChecked or checkBox_div.isChecked){
                //dividir
                mensaje_respuesta += "Division: " + div() + "\n"
                txt_respuesta.setText(mensaje_respuesta)
            }

            //limpiar variable
            mensaje_respuesta = ""
        }
    }

    fun print(mensaje: String) {
        Toast.makeText(this.context, mensaje, Toast.LENGTH_SHORT).show()
    }

    fun sum(): String{
        var numero1: Double = txt_numero1.text.toString().toDouble()
        var numero2: Double = txt_numero2.text.toString().toDouble()

        var resultado: Double = numero1 + numero2 //tipo double
        //txt_respuesta.setText(resultado.toString())
        return resultado.toString()
    }
    fun res(): String{
        var numero1: Double = txt_numero1.text.toString().toDouble()
        var numero2: Double = txt_numero2.text.toString().toDouble()

        var resultado: Double = numero1 - numero2 //tipo double
        //txt_respuesta.setText(resultado.toString())
        return resultado.toString()
    }
    fun mul(): String{
        var numero1: Double = txt_numero1.text.toString().toDouble()
        var numero2: Double = txt_numero2.text.toString().toDouble()

        var resultado: Double = numero1 * numero2 //tipo double
        //txt_respuesta.setText(resultado.toString())
        return resultado.toString()
    }
    fun div(): String{
        var numero1: Double = txt_numero1.text.toString().toDouble()
        var numero2: Double = txt_numero2.text.toString().toDouble()

        var resultado: Double = numero1 / numero2 //tipo double
        //txt_respuesta.setText(resultado.toString())
        return resultado.toString()
    }

    //hacer lo mismo con checkbox

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}