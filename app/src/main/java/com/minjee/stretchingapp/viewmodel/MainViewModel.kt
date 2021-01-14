package com.minjee.stretchingapp.viewmodel

import androidx.lifecycle.ViewModel
import com.minjee.stretchingapp.model.ListData
import com.minjee.stretchingapp.model.StretchMove

/*
 *      MainViewModel
 *      - viewModel that updates the MainFragment (the visible UI)
 *      - gets the data from model
 */
class MainViewModel: ViewModel() {

    private val listData = ListData(ArrayList())

    fun initializeListOfMoves() {
        val move1 = StretchMove( "Piriformis Stretch",
                             "1. Sit on the floor with both legs extended in front of you.\n" +
                                                "2. Cross your right leg over your left, and place your right foot flat on the floor.\n" +
                                                "3. Place your right hand on the floor behind your body.\n" +
                                                "4. Place your left hand on your right quad or your left elbow on your right knee (as shown) and press your right leg to the left as you twist your torso to the right.\n" +
                                                "5. If the spinal rotation bothers your back, take it out and simply use your left hand to pull your right quad in and to the left.")
        val move2 = StretchMove( "Standing Hamstring Stretch",
                             "1. Stand tall with your feet hip-width apart, knees slightly bent, arms by your sides.\n" +
                                                "2. Exhale as you bend forward at the hips, lowering your head toward floor, while keeping your head, neck and shoulders relaxed.\n" +
                                                "3. Wrap your arms around backs of your legs and hold anywhere from 45 seconds to two minutes.\n" +
                                                "4. Bend your knees and roll up when you're done.")
        val move3 = StretchMove( "Lunge With Spinal Twist",
                             "1. Start standing with your feet together.\n" +
                                                "2. Take a big step forward with your left foot, so that you are in a staggered stance.\n" +
                                                "3. Bend your left knee and drop into a lunge, keeping your right leg straight behind you with your toes on the ground, so you feel a stretch at the front of your right thigh.\n" +
                                                "4. Place your right hand on the floor and twist your upper body to the left as you extend your left arm toward the ceiling.\n" +
                                                "5. Hold for 30 seconds to 2 minutes.\n" +
                                                "6. Repeat on the other side.")
        val move4 = StretchMove( "Figure Four Stretch",
                             "1. Lie on your back with your feet flat on the floor.\n" +
                                                "2. Cross your left foot over your right quad.\n" +
                                                "3. Lift your right leg off the floor. Grab onto the back of your right leg and gently pull it toward your chest.\n" +
                                                "4. When you feel a comfortable stretch, hold there.\n" +
                                                "5. Hold for 30 seconds to 2 minutes.\n" +
                                                "6. Switch sides and repeat.")
        val move5 = StretchMove( "Knee to Chest Stretch",
                             "1. Lie on your back with both legs extended.\n" +
                                                "2. Pull your right knee into your chest, while keeping the left leg straight and your lower back pressed into the floor.\n" +
                                                "3. Hold for 30 seconds to 2 minutes.\n" +
                                                "4. Repeat on the other leg.")

        listData.listOfMoves.add(move1)
        listData.listOfMoves.add(move2)
        listData.listOfMoves.add(move3)
        listData.listOfMoves.add(move4)
        listData.listOfMoves.add(move5)
    }

    fun getListOfMoves(): ListData {
        return listData
    }
}