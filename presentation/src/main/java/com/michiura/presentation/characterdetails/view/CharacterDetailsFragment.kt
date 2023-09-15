package com.michiura.presentation.characterdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.michiura.domain.repository.entities.CharacterDetailsEntity
import com.michiura.presentation.R
import com.michiura.presentation.characterdetails.viewmodel.CharacterDetailsViewModel
import com.michiura.presentation.characterdetails.viewmodel.CharacterDetailsViewModelFactory
import com.michiura.presentation.characterslist.view.CharactersListFragment
import com.michiura.presentation.commons.ViewState
import com.michiura.presentation.databinding.FragmentCharacterDetailsBinding

class CharacterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailsBinding

    private lateinit var characterId: String

    private val viewModel: CharacterDetailsViewModel by activityViewModels {
        CharacterDetailsViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            characterId = it.getString(EXTRA_CHARACTER_ID).orEmpty()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCharacterDetails(1017100)
        observeViewStates()

    }

    private fun observeViewStates() {
        viewModel.characterDetailsViewState.observe(viewLifecycleOwner) {
            when (it) {
                is ViewState.Success<CharacterDetailsEntity> -> {
                    bindCharacterDetails(it.data)
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

    private fun bindCharacterDetails(character: CharacterDetailsEntity) {
        binding.apply {
            ivAvatar.load(data = character.thumbnail.thumbnailFullPath) {
                crossfade(true)
            }
            tvCharacterName.text = character.name
            tvCharacterDetails.text = character.description
        }
    }

    companion object {
        private const val EXTRA_CHARACTER_ID: String = "EXTRA_CHARACTER_ID"

        @JvmStatic
        fun newInstance(characterId: String) =
            CharactersListFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_CHARACTER_ID, characterId)
                }
            }
    }
}
