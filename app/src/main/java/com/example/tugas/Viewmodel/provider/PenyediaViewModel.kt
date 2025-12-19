package com.example.tugas.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tugas.repositori.AplikasiDataSiswa
import com.example.tugas.viewmodel.EntryViewModel
import com.example.tugas.viewmodel.HomeViewModel

// Extension function untuk mengambil instance aplikasi
fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa)

object PenyediaViewModel {
    val Factory = viewModelFactory {
        // Initializer untuk HomeViewModel
        initializer {
            HomeViewModel(aplikasiDataSiswa().container.repositoryDataSiswa)
        }
        // Initializer untuk EntryViewModel
        initializer {
            EntryViewModel(aplikasiDataSiswa().container.repositoryDataSiswa)
        }
    }
}