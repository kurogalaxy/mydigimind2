package lumbreras.marquez.mydigimind.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.elemento_view.view.*
import lumbreras.marquez.mydigimind.Actividad
import lumbreras.marquez.mydigimind.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var actividades=ArrayList<Actividad>()
    var adaptador: AdaptadorActividad?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)

        cargarActividades()

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        adaptador=AdaptadorActividad(root.context,actividades)
        root.findViewById<GridView>(R.id.gridViewActividades).adapter=adaptador

        return root
    }

    fun cargarActividades(){

        actividades.add(Actividad("Practice", "Everyday", "17:00"))
        actividades.add(Actividad("Practice", "Everyday", "17:00"))
        actividades.add(Actividad("Practice", "Everyday", "17:00"))
        actividades.add(Actividad("Practice", "Everyday", "17:00"))
        actividades.add(Actividad("Practice", "Everyday", "17:00"))
        actividades.add(Actividad("Practice", "Everyday", "17:00"))
        actividades.add(Actividad("Practice", "Everyday", "17:00"))
        actividades.add(Actividad("Practice", "Everyday", "17:00"))
        actividades.add(Actividad("Practice", "Everyday", "17:00"))

    }

    class AdaptadorActividad: BaseAdapter {

        var act= ArrayList<Actividad>()
        var contexto: Context? = null

        constructor(contexto: Context, peliculas: ArrayList<Actividad>){
            this.contexto=contexto
            this.act=peliculas
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var act=act[position]

            var inflater=contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflater.inflate(R.layout.elemento_view, null)
            vista.tx_titulo.setText(act.titulo)
            vista.tx_desc.setText(act.descripcion)
            vista.tx_hora.setText(act.hora)

            return vista

        }

        //Estos tres de abajo no importan de momento se les pone return cualquier cosa
        override fun getItem(position: Int): Any {
            return act[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return act.size
        }

    }
}