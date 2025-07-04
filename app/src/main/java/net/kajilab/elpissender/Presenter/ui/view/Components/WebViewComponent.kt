package net.kajilab.elpissender.Presenter.ui.view.Components

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewComponent(
    geoJsonString: String,
    topAppBarActions: (List<@Composable () -> Unit>) -> Unit
) {
    val context = LocalContext.current
    var webView = remember { WebView(context) }

    topAppBarActions(
        listOf {
            IconButton(onClick = {
                webView.reload()
            }) {
                Icon(Icons.Filled.Refresh, "Trigger Refresh")
            }
        }
    )

    // WebView表示
    AndroidView(
        factory = {
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        },
        update = {
            webView = it
            it.settings.javaScriptEnabled = true
            it.settings.domStorageEnabled = true
            
            // WebViewClientを一度だけ設定
            it.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    // JavaScript関数を呼び出してGeoJSONを渡す
                    val escaped = geoJsonString.replace("'", "\\'")
                    view?.evaluateJavascript("window.setGeoJsonData('" + escaped + "');", null)
                }
            }
            
            // assetsのHTMLを読み込む
            it.loadUrl("file:///android_asset/floor_map.html")
        }
    )
}

@Preview
@Composable
fun PreviewWebViewComponent() {
    WebViewComponent(
        geoJsonString = "{}",
        topAppBarActions = {}
    )
}
