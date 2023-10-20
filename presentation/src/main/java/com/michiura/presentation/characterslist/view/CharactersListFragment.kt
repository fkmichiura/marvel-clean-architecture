package com.michiura.presentation.characterslist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.michiura.domain.entities.CharacterEntity
import com.michiura.presentation.R
import com.michiura.presentation.characterdetails.view.CharacterDetailsFragment
import com.michiura.presentation.characterslist.viewmodel.CharactersListViewModel
import com.michiura.presentation.characterslist.viewmodel.CharactersListViewModelFactory
import com.michiura.presentation.commons.FragmentExt.replaceFragment
import com.michiura.presentation.commons.ViewState
import com.michiura.presentation.databinding.FragmentCharactersListBinding

class CharactersListFragment : Fragment() {

    private lateinit var binding: FragmentCharactersListBinding

    private val viewModel: CharactersListViewModel by activityViewModels {
        CharactersListViewModelFactory()
    }

    private val adapter: CharactersListAdapter by lazy {
        CharactersListAdapter(onCharacterItemClicked = this::onCharacterItemClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewStates()
        setupRecyclerView()
        viewModel.getCharactersList()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
    }

    private fun onCharacterItemClicked(characterId: Int) {
        val activity = requireActivity() as AppCompatActivity

        activity.replaceFragment(
            containerId = R.id.containerView,
            fragment = CharacterDetailsFragment.newInstance(characterId = characterId)
        )
    }

    private fun observeViewStates() {
        viewModel.charactersListViewState.observe(viewLifecycleOwner) {
            when (it) {
                is ViewState.Loading -> binding.loading.isVisible = it.showLoading

                is ViewState.Success<List<CharacterEntity>> -> {
                    adapter.addCharacters(characters = it.data)
                }

                is ViewState.Error -> {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.fetch_character_details_error_message),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
