package com.example.a31agostobasicactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.a31agostobasicactivity.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var txt_numero1: EditText
    private lateinit var txt_numero2: EditText
    private lateinit var txt_respuesta: EditText

    private lateinit var spiner_operaciones: Spinner


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        txt_numero1 = binding.editTextNumero1SecondF
        txt_numero2 = binding.editTextNumero2SecondF
        txt_respuesta = binding.editTextRespuestaSecondF

        spiner_operaciones = binding.spinnerOpciones

        var listaOpciones: List<String> = listOf("Sumar","Restar","Multiplicar","Dividir")

        // array adapter: permite mostrar en la parte visual algo definido desde la parte logica
        // arrayadapter(contexto,como se mostrara , elementos a mostrar)

        // definir el array adapter ArrayAdapter <String> adapter = new ArrayAdapter

        val miArrayAdapter =
            this.context?.let { ArrayAdapter(it,android.R.layout.simple_spinner_item,listaOpciones) }

        spiner_operaciones.adapter = miArrayAdapter// aqui asignarle el array adapter
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment)
        }

        binding.imageButtonCalcularSecondF.setOnClickListener{
            //boton calculadora
            var spiner_operaciones_texto: String = spiner_operaciones.selectedItem.toString()

            var textoNumero1: String =  txt_numero1.text.toString()
            var textoNumero2: String =  txt_numero2.text.toString()

            var resultadoOperacion: String = ""

            if (!(textoNumero1 == "") and !(textoNumero2 == "")){
                when (spiner_operaciones_texto) {
                    "Sumar" -> resultadoOperacion = sum()         //txt_respuesta.setText("suma")
                    "Restar" -> resultadoOperacion = res()
                    "Multiplicar" -> resultadoOperacion = mul()
                    "Dividir" -> resultadoOperacion = div()
                }
                txt_respuesta.setText(resultadoOperacion)
            }else{
                print("Porfavor ingrese los numeros")
            }



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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}