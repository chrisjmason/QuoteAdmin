package com.and.cmason.quoteadmin.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.and.cmason.quoteadmin.R
import com.and.cmason.quoteadmin.addquote.AddQuoteActivity
import com.and.cmason.quoteadmin.data.models.QuoteModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeContract.View {

    @Inject
    lateinit var presenter: HomePresenter

    lateinit var adapter:HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        presenter.onBind(this)
        setContentView(R.layout.activity_home)
        setUpUi()
        presenter.getList()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        presenter.getList()
    }

    override fun showList(quoteList: List<QuoteModel>) {
        Collections.reverse(quoteList)
        adapter.quoteList = quoteList
        adapter.notifyDataSetChanged()
    }

    override fun quoteDeleted() {
        presenter.getList()
        Toast.makeText(this, "Quote deleted", Toast.LENGTH_LONG).show()
    }

    override fun quoteNotDeleted(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun setUpUi(){
        setUpRecyclerView()
        setUpAddQuoteButton()
    }

    fun setUpRecyclerView(){
        adapter = HomeAdapter(ArrayList<QuoteModel>(), this, presenter)
        quote_recycler_view.layoutManager = LinearLayoutManager(this)
        quote_recycler_view.adapter = adapter
    }

    fun setUpAddQuoteButton(){
        add_quote_button.setOnClickListener {
            startActivity(Intent(this, AddQuoteActivity::class.java))
        }
    }
}
