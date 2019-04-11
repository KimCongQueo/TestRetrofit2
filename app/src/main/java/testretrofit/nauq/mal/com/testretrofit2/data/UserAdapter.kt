package testretrofit.nauq.mal.com.testretrofit2.data

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import testretrofit.nauq.mal.com.testretrofit2.R
import testretrofit.nauq.mal.com.testretrofit2.data.model.Users

class UserAdapter(val items: ArrayList<Users>?, val mContext: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        if (items == null) {
            return 0
        } else return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (items != null) {
            holder?.tvName?.text = items.get(position).firstName + " " + items.get(position).lastName
            Glide.with(mContext).load(items.get(position).avatar).into(holder?.image)
        }
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvName = view!!.tvName
    var image = view!!.imgAva
}
