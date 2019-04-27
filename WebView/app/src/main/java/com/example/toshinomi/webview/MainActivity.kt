package com.example.toshinomi.webview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val m_strUri: String = "https://www.google.com/"

    private var m_btnBack: Button? = null
    private var m_btnFoward: Button? = null
    private var m_btnReload: Button? = null
    private var m_textUri: EditText? = null
    private var m_webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        InitLayout()

        HomeWebView()
    }

    fun InitLayout() {
        m_btnBack = findViewById(R.id.buttonBack)
        m_btnBack?.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                BackWebView()
            }
        })

        m_btnFoward = findViewById(R.id.buttonForward)
        m_btnFoward?.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                FowardWebView()
            }
        })

        m_btnReload = findViewById(R.id.buttonReload)
        m_btnReload?.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                ReloadWebView()
            }
        })

        m_textUri = findViewById(R.id.editTextUri)
        m_textUri?.setOnKeyListener(object: View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, e: KeyEvent?): Boolean {
                if((e?.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ShowWebView(m_textUri?.text.toString())
                }
                return true
            }
        })

        m_webView = findViewById(R.id.webView)
    }

    fun BackWebView(): Boolean
    {
        var bRst: Boolean = true
        try
        {
            m_webView?.goBack()
        }
        catch (e: Exception)
        {
            bRst = false
        }

        return bRst
    }

    fun FowardWebView(): Boolean
    {
        var bRst: Boolean = true
        try
        {
            m_webView?.goForward()
        }
        catch(e: Exception)
        {
            bRst = false
        }

        return bRst
    }

    fun ReloadWebView(): Boolean
    {
        var bRst: Boolean = true
        try
        {
            m_webView?.reload()
        }
        catch(e: Exception)
        {
            bRst = false
        }

        return bRst
    }

    fun HomeWebView(): Boolean
    {
        m_textUri?.setText(m_strUri)
        return ShowWebView(m_strUri)
    }

    fun ShowWebView(_strUri: String?): Boolean
    {
        var bRst: Boolean = true
        try
        {
            m_webView?.loadUrl(_strUri)
            m_textUri?.setText(_strUri)
        }
        catch(e: Exception)
        {
            bRst = false
        }

        return bRst
    }
}