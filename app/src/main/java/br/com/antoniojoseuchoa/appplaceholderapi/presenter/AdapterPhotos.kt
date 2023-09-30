package br.com.antoniojoseuchoa.appplaceholderapi.presenter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniojoseuchoa.appplaceholderapi.data.model.Foto
import br.com.antoniojoseuchoa.appplaceholderapi.databinding.ItemPhotoBinding
import br.com.antoniojoseuchoa.appplaceholderapi.domain.models.FotoDomain
import br.com.antoniojoseuchoa.appplaceholderapi.presenter.ui.DetailPhotoActivity

class AdapterPhotos(): RecyclerView.Adapter<AdapterPhotos.ViewHolderPhoto>() {

    private var list = listOf<FotoDomain>()

    fun setListPhotos(list: List<FotoDomain>){
         this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPhoto {
           val layoutInflater = LayoutInflater.from(parent.context)
           val binding = ItemPhotoBinding.inflate(layoutInflater, parent, false)
           return ViewHolderPhoto( binding )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolderPhoto, position: Int) {
           val photo = list[position]
           holder.bind( photo )
    }

    inner class ViewHolderPhoto(val binding: ItemPhotoBinding): RecyclerView.ViewHolder(binding.root){
         fun bind(item: FotoDomain){
             binding.tvTitulo.text = item.title

             binding.itemPhoto.setOnClickListener {
                 val intent = Intent(binding.root.context, DetailPhotoActivity::class.java)
                 intent.putExtra("photo", item)
                 binding.root.context.startActivity(intent)
             }
         }
    }
}