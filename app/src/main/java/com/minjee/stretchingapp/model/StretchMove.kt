package com.minjee.stretchingapp.model

import com.minjee.stretchingapp.viewmodel.MoveListItemClickListener

data class StretchMove(val nameOfTheMove: String, val descriptionOfTheMove: String, val itemClick: MoveListItemClickListener)
