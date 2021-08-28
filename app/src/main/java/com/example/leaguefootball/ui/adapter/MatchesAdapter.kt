package com.example.leaguefootball.ui.adapter

import com.example.leaguefootball.R
import com.example.leaguefootball.base.BaseRecyclerAdapter
import com.example.leaguefootball.databinding.ItemMatchBinding
import com.example.leaguefootball.room.LeagueDao
import com.example.leaguefootball.room.models.MatchEntity
import com.example.leaguefootball.utils.extentions.load

class MatchesAdapter(var list: ArrayList<MatchEntity>, val leagueDao: LeagueDao) :
    BaseRecyclerAdapter<MatchEntity, ItemMatchBinding>() {
    override val layoutRes: Int
        get() = R.layout.item_match

    override val arrayList: ArrayList<MatchEntity>
        get() = list

    override fun bindView(
        binding: ItemMatchBinding,
        currentData: MatchEntity,
        position: Int
    ) {
        val guestTeam = leagueDao.getTeam(currentData.guestTeamId)
        val hostTeam = leagueDao.getTeam(currentData.hostTeamId)
        //null gelebilir diye check ediyoruz
        guestTeam?.let {
            binding.tvGuestName.text = guestTeam.name
            binding.ivGuestLogo.load(binding.root.context, guestTeam.photoUrl)
        }
        hostTeam?.let {
            binding.tvHostName.text = hostTeam.name
            binding.ivHostLogo.load(binding.root.context, hostTeam.photoUrl)
        }
        binding.tvScore.text = "${currentData.hostScore} : ${currentData.guestScore}"
    }
}