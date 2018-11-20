package com.example.kit1_03_kotlin_counter


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var mCountKits = 0
    private var mCountDolphins  = 0
    private val KEY_COUNT_Dolphins  = "COUNT_DOLPHINS"
    private val KEY_COUNT_Kits = "COUNT_KITS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Восстановление счетчиков после поворота:
        if (savedInstanceState ==null ) return
        mCountDolphins =  savedInstanceState.getInt(KEY_COUNT_Dolphins, 0)
        mCountKits = savedInstanceState.getInt(KEY_COUNT_Kits, 1)

        // Вариант с Listener (тогда onClick не нужны) можно так:
        //  button.setOnClickListener { view -> textView.text = " L   Ты кто такой? \n  Давай, до свидания!"}
        // button_Counter_Kits.setOnClickListener{  view -> textView.text = "L Я насчитал " + ++mCountKits + " Китов" }
        // button_Сounter_Dolphins.setOnClickListener {  view ->textView.text = "L Я насчитал   ${++mCountDolphins}  Дельфинов" }

    }

    fun onClick(view: View) {textView.text = "F  Ты кто такой? \n  Давай, до свидания!"}
    fun onKits(view: View) {textView.text = "F Я насчитал " + ++mCountKits + " Китов"}
    fun onDolphins  (view: View) {textView.text = "F Я насчитал   ${++mCountDolphins}  Дельфинов"}
    // Запоминаем счетчики
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT_Dolphins,  mCountDolphins )
        outState.putInt(KEY_COUNT_Kits, mCountKits)
    }
}
/*
Жизненный цикл при повороте
При повороте активность проходит через цепочку различных состояний. Порядок следующий.

onPause()
onStop()
onDestroy()
onCreate()
onStart()
onResume()
 */

/*
Ориентация у фрагментов
Позже вы узнаете о существовании фрагментов. Может возникнуть такая ситуация,
 когда вы захотите выводить конкретный фрагмент в нужной ориентации.
  У фрагментов есть собственный жизненный цикл,
   и вы можете реализовать свой код в методах фрагмента:

@Override
public void onResume() {
    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
}

@Override
public void onPause() {
	getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    // ваш код
	super.onPause();
}
Я с таким случаем не встречался, но оставлю как памятку.
 */
