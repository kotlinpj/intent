package com.example.intent

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class novaconta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_novaconta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tv_termos_uso: TextView = findViewById(R.id.tv_termos)
        val textoCompleto = tv_termos_uso.text.toString()
        val trechoNegrito = "Termos de Uso"

        val spannable = SpannableString(textoCompleto)

        val start = textoCompleto.indexOf(trechoNegrito)
        val end = start + trechoNegrito.length

        if (start >= 0) {
            spannable.setSpan(
                StyleSpan(Typeface.BOLD), // negrito
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            spannable.setSpan(
                UnderlineSpan(),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        tv_termos_uso.text = spannable
    }

}