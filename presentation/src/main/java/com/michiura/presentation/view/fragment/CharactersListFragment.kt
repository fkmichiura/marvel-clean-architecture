package com.michiura.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.michiura.domain.repository.entities.CharacterEntity
import com.michiura.presentation.databinding.FragmentCharactersListBinding
import com.michiura.presentation.state.ViewState
import com.michiura.presentation.view.CharactersListViewModelFactory
import com.michiura.presentation.view.viewmodel.CharactersListViewModel
import java.lang.Exception

class CharactersListFragment : Fragment() {

    private lateinit var binding: FragmentCharactersListBinding

    private val viewModel: CharactersListViewModel =
        ViewModelProvider(
            owner = this,
            factory = CharactersListViewModelFactory()
        )[CharactersListViewModel::class.java]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCharactersList()
        observeViewStates()
    }

    private fun observeViewStates() {
        viewModel.charactersListViewState.observe(viewLifecycleOwner) {
            when(it) {
                is ViewState.Success<List<CharacterEntity>> -> {
                    print("list: ${it.data}")
                }
                is ViewState.Error -> {

                }
            }
        }
    }
}