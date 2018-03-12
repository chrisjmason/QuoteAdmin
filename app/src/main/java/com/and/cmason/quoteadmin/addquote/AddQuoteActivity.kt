package com.and.cmason.quoteadmin.addquote

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.and.cmason.quoteadmin.R
import com.and.cmason.quoteadmin.data.models.QuoteModel
import com.and.cmason.quoteadmin.home.HomeContract
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_add_quote.*
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

/**
 * Created by cmason on 14/02/2018.
 */
class AddQuoteActivity: AppCompatActivity(), AddQuoteContract.View {

    @Inject
    lateinit var presenter: AddQuoteContract.Presenter

    var isEdit = false
    var quoteId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        presenter.onBind(this)
        setContentView(R.layout.activity_add_quote)
        getExtras()
        setUpUi()
    }

    override fun quoteAdded() {
        onBackPressed()
    }

    override fun quoteNotAdded(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun getExtras(){
        intent.extras?.let {
            isEdit = true;
            quoteId = intent.extras.getString("QUOTE_ID")
            quote_input_text.setText(intent.extras.getString("QUOTE_CONTENT"))
            author_input_text.setText(intent.extras.getString("QUOTE_AUTHOR"))
        }
    }

    fun setUpUi(){
        if(isEdit){
            confirm_add_quote_button.text = "Confirm edit"
            confirm_add_quote_button.setOnClickListener {
                val quoteToUpdate = QuoteModel(quote_input_text.text.toString(), author_input_text.text.toString(), quoteId)
                presenter.updateQuote(quoteToUpdate)
            }
        }else{
            confirm_add_quote_button.setOnClickListener {
                val quoteToAdd = QuoteModel(quote_input_text.text.toString(), author_input_text.text.toString(), null)
                presenter.addQuote(quoteToAdd)
            }
        }


    }
}