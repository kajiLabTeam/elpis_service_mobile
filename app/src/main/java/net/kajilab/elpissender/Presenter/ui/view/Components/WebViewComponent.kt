package net.kajilab.elpissender.Presenter.ui.view.Components

import android.annotation.SuppressLint
import android.util.Base64
import android.view.ViewGroup
import android.webkit.JavascriptInterface
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
import java.nio.charset.StandardCharsets

// JavaScript Interface for direct data communication
class GeoJsonInterface(private val geoJsonString: String, private val highlightRoomId: String?) {
    @JavascriptInterface
    fun getGeoJsonData(): String {
        return geoJsonString
    }
    
    @JavascriptInterface
    fun getHighlightRoomId(): String? {
        return highlightRoomId
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewComponent(
    geoJsonString: String,
    highlightRoomId: String? = null,
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
            
            // JavaScript Interfaceを追加
            it.addJavascriptInterface(GeoJsonInterface(geoJsonString, highlightRoomId), "Android")
            
            // WebViewClientを一度だけ設定
            it.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    // 方法1: Base64エンコードを使用
                    val encodedGeoJson = Base64.encodeToString(
                        geoJsonString.toByteArray(StandardCharsets.UTF_8),
                        Base64.NO_WRAP
                    )
                    view?.evaluateJavascript(
                        "window.setGeoJsonDataFromBase64('$encodedGeoJson');",
                        null
                    )
                    
                    // 方法2: JavaScript Interfaceを使用（バックアップ）
                    view?.evaluateJavascript(
                        "window.loadGeoJsonFromAndroid();",
                        null
                    )
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
        highlightRoomId = null,
        topAppBarActions = {}
    )
}
