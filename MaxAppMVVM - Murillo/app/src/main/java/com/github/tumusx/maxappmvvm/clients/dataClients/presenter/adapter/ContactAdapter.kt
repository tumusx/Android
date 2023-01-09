package com.github.tumusx.maxappmvvm.clients.dataClients.presenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.tumusx.maxappmvvm.R
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.Contato
import com.github.tumusx.maxappmvvm.databinding.ContainerContactItemsBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    private var contactList = emptyList<Contato>()

    class ContactViewHolder(private val binding: ContainerContactItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setupUI(contact: Contato) {
            binding.txtCelularCliente.text = contact.celular
            binding.txtNomeClient.text = contact.nome
            binding.txtTelefoneClient.text = contact.telefone
            binding.txtConjugeClient.text = contact.conjuge
            binding.txtTipoClient.text = contact.tipo
            binding.txtTimeClient.text = contact.time
            binding.txtEmailClient.text = contact.e_mail
            binding.txtDataNascimentoClient.text = contact.dataNascimento
            binding.txtDataNasciConjugeClient.text = contact.dataNascimentoConjuge ?: "N/A"
            binding.txtHobbieClient.text = binding.txtHobbieClient.context.getString(R.string.INDEFINIDO)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(contacts: List<Contato>) {
        notifyDataSetChanged()
        contactList = contacts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ContactViewHolder(
        ContainerContactItemsBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.setupUI(contactList[position])
    }

    override fun getItemCount() = contactList.size
}