package com.antoniocostadossantos.desafioandroid.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antoniocostadossantos.desafioandroid.R
import com.antoniocostadossantos.desafioandroid.databinding.RepositoyItemBinding
import com.antoniocostadossantos.desafioandroid.model.RepositoryModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private var items: List<RepositoryModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding =
            RepositoyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun setList(liveList: List<RepositoryModel>) {
        this.items = liveList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = items[position]

        val nomeRepo = holder.binding.tvNomeRepositorio
        val nomeUsuario = holder.binding.tvNomeUsuario
        val estrelas = holder.binding.tvEstrelas
        val forks = holder.binding.tvForks
        val foto = holder.binding.ivFotoPerfil

        nomeRepo.text = "Repository: ${item.name}"
        nomeUsuario.text = "Owner: ${item.owner.login}"
        estrelas.text = "Stars: ${item.stargazers_count}"
        forks.text = "Forks: ${item.forks_count}"

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_baseline_error_24)
            .error(R.drawable.ic_baseline_cloud_download_24)

        Glide.with(holder.binding.ivFotoPerfil)
            .applyDefaultRequestOptions(requestOptions)
            .load(item.owner.avatar_url)
            .into(foto)

        holder.binding.itemRepository.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(item.html_url))
            it.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(val binding: RepositoyItemBinding) : RecyclerView.ViewHolder(binding.root) {}


}