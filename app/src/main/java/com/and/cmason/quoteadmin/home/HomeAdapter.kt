package com.and.cmason.quoteadmin.home

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.and.cmason.quoteadmin.R
import com.and.cmason.quoteadmin.addquote.AddQuoteActivity
import com.and.cmason.quoteadmin.data.models.QuoteModel
import kotlinx.android.synthetic.main.quote_card.view.*
import javax.inject.Inject

/**
 * Created by cmason on 08/02/2018.
 */
class HomeAdapter(var quoteList: List<QuoteModel>, context: Context, presenter: HomePresenter) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>()
{
    val context:Context
    val presenter:HomePresenter

    init {
        this.context = context
        this.presenter = presenter
    }

    override fun getItemCount(): Int = quoteList.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int){
        holder.bind(quoteList.get(position))
        Log.d("in bind viewholder", quoteList.size.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeViewHolder{
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.quote_card, parent, false)
        return HomeViewHolder(view, context, presenter)
    }

    class HomeViewHolder(itemView: View, context: Context, presenter: HomePresenter): RecyclerView.ViewHolder(itemView){
        val context:Context
        val presenter:HomePresenter

        init {
            this.context = context
            this.presenter = presenter
        }

        fun bind(quote: QuoteModel){
            itemView.quote_content_text.text = quote.quote
            itemView.quote_author_text.text = quote.author

            itemView.edit_button.setOnClickListener {
                val intent = Intent(context, AddQuoteActivity::class.java)
                intent.putExtra("QUOTE_ID", quote._id)
                intent.putExtra("QUOTE_CONTENT", quote.quote)
                intent.putExtra("QUOTE_AUTHOR", quote.author)
                context.startActivity(intent)
            }

            itemView.delete_button.setOnClickListener {
                quote._id?.let { presenter.deleteQuote(quote._id) }
            }

        }
    }
}
