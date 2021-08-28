package com.example.leaguefootball.ui.fixture

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProvider
import com.example.leaguefootball.R
import com.example.leaguefootball.base.BaseActivity
import com.example.leaguefootball.databinding.ActivityFixtureBinding
import com.example.leaguefootball.room.models.MatchEntity
import com.example.leaguefootball.room.models.TeamEntity
import com.example.leaguefootball.room.models.WeekEntity
import com.example.leaguefootball.ui.main.MainActivity
import java.util.*

class FixtureActivity : BaseActivity<ActivityFixtureBinding>() {

    lateinit var viewModel : FixtureViewModel
    lateinit var dialogProgress: Dialog


    override val layoutRes: Int
        get() = R.layout.activity_fixture

    override fun onCreated() {
        /*if (!leagueDao.getWeeks().isNullOrEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }
         */
        viewModel = ViewModelProvider(this).get(FixtureViewModel::class.java)

        //her actigimizda data karmasasi olmasin diye verileri resetliyorum
        viewModel.resetRoom()

        dialogProgress = Dialog(this)
        dialogProgress.setContentView(R.layout.item_loading)
        dialogProgress.setCanceledOnTouchOutside(false)
        dialogProgress.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


    }

    override fun listener() {
        binding.btnFixture.setOnClickListener {
            doFixture()
        }
    }

    private fun doFixture() {
        showLoading(true)
        //ilk takimlari
        createTeams()
        // sonra haftalari
        createWeeks()
        // en sonda maclari olusturuyorum
        createMatch()
        showLoading(false)
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }

    private fun showLoading(isShow: Boolean) {
        if (isShow)
            dialogProgress.show()
        else
            dialogProgress.dismiss()
    }


    private fun createTeams() {
        val teamNames = arrayListOf(
            "Arizona Cardinals",
            "Baltimore Ravens",
            "Atlanta Falcons",
            "Green Bay Packers",
            "Indianapolis Colts",
            "Detroit Lions",
            "Houston Texans",
            "Denver Broncos",
            "Dallas Cowboys",
            "Cleveland Browns",
            "Chicago Bears",
            "Cincinnati Bengals",
            "Carolina Panthers",
            "Buffalo Bills"
        )
        val teamLogo = arrayListOf(
            "https://static.www.nfl.com/image/private/f_auto/league/u9fltoslqdsyao8cpm0k",
            "https://res.cloudinary.com/nflleague/image/private/f_auto/league/ucsdijmddsqcj1i9tddd",
            "https://static.www.nfl.com/image/private/f_auto/league/d8m7hzpsbrl6pnqht8op",
            "https://res.cloudinary.com/nflleague/image/private/f_auto/league/gppfvr7n8gljgjaqux2x",
            "https://static.www.nfl.com/image/private/f_auto/league/ketwqeuschqzjsllbid5",
            "https://res.cloudinary.com/nflleague/image/private/f_auto/league/ocvxwnapdvwevupe4tpr",
            "https://static.www.nfl.com/image/private/f_auto/league/bpx88i8nw4nnabuq0oob",
            "https://res.cloudinary.com/nflleague/image/private/f_auto/league/t0p7m5cjdjy18rnzzqbx",
            "https://static.www.nfl.com/image/private/f_auto/league/ieid8hoygzdlmzo0tnf6",
            "https://static.www.nfl.com/image/private/f_auto/league/fgbn8acp4opvyxk13dcy",
            "https://static.www.nfl.com/image/private/f_auto/league/ra0poq2ivwyahbaq86d2",
            "https://res.cloudinary.com/nflleague/image/private/f_auto/league/okxpteoliyayufypqalq",
            "https://static.www.nfl.com/image/private/f_auto/league/ervfzgrqdpnc7lh5gqwq",
            "https://res.cloudinary.com/nflleague/image/private/f_auto/league/giphcy6ie9mxbnldntsf",
        )

        teamNames.forEachIndexed { index, s ->
            viewModel.addTeams(TeamEntity(name = s, photoUrl = teamLogo[index]))
        }
    }

    private fun createWeeks() {
        // takim sayisini cekiyorum
        val teams = viewModel.getTeamCount()
        for (i in 0 until (teams * 2) - 2) {
            viewModel.addWeek(WeekEntity(name = "${i + 1}. Week", matches = arrayListOf()))
        }

    }

    private fun createMatch() {
        // takim ve haftalari cekiyorum
        val teams = viewModel.getTeams()
        val weeks = viewModel.getWeeks()
        // bos ise ekleme yaptirmiyorum hata oldugundan
        if (teams.isEmpty() || weeks.isEmpty())
            finish()

        var firstTeam = teams.first()

        // hafta sayisi kadar donuyorum
        for2@ for (w in 0 until weeks.size) {
            if (weeks.size / 2 + 1 == w + 1) {
                teams.reverse()
            }
            firstTeam = teams.first()
            // ekleme yaptıktan sonra silebilecegim bos bir liste olusturuyorum
            val mockTeams = arrayListOf<TeamEntity>()
            mockTeams.addAll(teams)
            // takim sayisi kadar sonuyorum ve first ve last ekledikten sonra onları siliyorum
            loo@ for (i in 0 until teams.size / 2) {
                if (mockTeams.isEmpty())
                    break@loo
                viewModel.addMatch(
                    MatchEntity(
                        hostScore = (0..8).random(),
                        guestScore = (0..8).random(),
                        guestTeamId = mockTeams.first().id,
                        hostTeamId = mockTeams.last().id,
                        weekId = weeks[w].id
                    )
                )
                mockTeams.remove(mockTeams.first())
                mockTeams.remove(mockTeams.last())
            }

            // algoritmaya gore, firstTeam hep sabit kalmalı ve diger takımlar liste icinde donmeli
            teams.remove(firstTeam)
            Collections.rotate(teams, 1)
            teams.add(0, firstTeam)
        }

    }
}