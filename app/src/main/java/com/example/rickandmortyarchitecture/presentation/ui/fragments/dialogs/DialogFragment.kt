package com.example.rickandmortyarchitecture.presentation.ui.fragments.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmortyarchitecture.databinding.FragmentDlalogBinding

class DialogFragment : DialogFragment() {

    private val args: DialogFragmentArgs by navArgs()
    private lateinit var binding: FragmentDlalogBinding


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentDlalogBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(activity)
            .setView(binding.root)
            .create()
        builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setupImage()
        return builder
    }


    private fun setupImage() {
        Glide.with(binding.imageBooksDialog)
            .load(args.image)
            .into(binding.imageBooksDialog)
    }


}