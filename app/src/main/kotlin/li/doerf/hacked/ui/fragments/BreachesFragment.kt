package li.doerf.hacked.ui.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import li.doerf.hacked.R
import li.doerf.hacked.db.entities.BreachedSite
import li.doerf.hacked.ui.adapters.BreachedSitesAdapter
import li.doerf.hacked.ui.viewmodels.BreachedSitesViewModel
import java.util.*

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class BreachesFragment : Fragment() {
    private lateinit var breachedSitesAdapter: BreachedSitesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragmentRootView = inflater.inflate(R.layout.fragment_breaches, container, false)

        val headingChevron = fragmentRootView.findViewById<ImageView>(R.id.show_details)
        headingChevron.setOnClickListener {
            val action = OverviewFragmentDirections.actionOverviewFragmentToAllBreachesFragment()
            fragmentRootView.findNavController().navigate(action)
        }

        val breachedSites: RecyclerView = fragmentRootView.findViewById(R.id.breached_sites_list)
        breachedSites.setHasFixedSize(true)
        val lmbs = LinearLayoutManager(context)
        breachedSites.layoutManager = lmbs
        breachedSites.adapter = breachedSitesAdapter

        return fragmentRootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        breachedSitesAdapter = BreachedSitesAdapter(activity!!.applicationContext, ArrayList(), true)
        val breachedSitesViewModel = ViewModelProviders.of(this).get(BreachedSitesViewModel::class.java)
        breachedSitesViewModel.breachesSitesMostRecent.observe(this, Observer { sites: List<BreachedSite> -> breachedSitesAdapter.addItems(sites) })
    }

    override fun onResume() {
        super.onResume()
        if (breachedSitesAdapter.getItemCount() == 0 ) {
            AllBreachesFragment.reloadBreachedSites(activity!!)
        }
    }

}
