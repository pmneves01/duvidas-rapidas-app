package br.com.suporte.duvidas;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.webkit.WebViewAssetLoader;
public class MainActivity extends Activity {
 private WebView web;
 private final String HOME="https://appassets.androidplatform.net/assets/index.html";
 private boolean external(String url){
  Uri u=Uri.parse(url);
  if("https".equals(u.getScheme()) && "appassets.androidplatform.net".equals(u.getHost()))return false;
  if("https".equals(u.getScheme()) && "wa.me".equals(u.getHost())){
   try{startActivity(new Intent(Intent.ACTION_VIEW,u));}catch(Exception e){Toast.makeText(this,"Não foi possível abrir o WhatsApp ou navegador.",Toast.LENGTH_LONG).show();}
  }
  return true;
 }
 @Override public void onCreate(Bundle state){
  super.onCreate(state);
  web=new WebView(this);setContentView(web);
  WebViewAssetLoader loader=new WebViewAssetLoader.Builder().addPathHandler("/assets/",new WebViewAssetLoader.AssetsPathHandler(this)).build();
  web.getSettings().setJavaScriptEnabled(true);
  web.getSettings().setDomStorageEnabled(true);
  web.getSettings().setAllowFileAccess(false);
  web.getSettings().setAllowContentAccess(false);
  web.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW);
  web.setWebViewClient(new WebViewClient(){
   @Override public WebResourceResponse shouldInterceptRequest(WebView v,WebResourceRequest r){return loader.shouldInterceptRequest(r.getUrl());}
   @Override public boolean shouldOverrideUrlLoading(WebView v,WebResourceRequest r){return external(r.getUrl().toString());}
  });
  web.getSettings().setSupportMultipleWindows(true);
  web.setWebChromeClient(new WebChromeClient(){
   @Override public boolean onCreateWindow(WebView v,boolean d,boolean g,android.os.Message m){
    if(!g)return false;
    WebView popup=new WebView(MainActivity.this);
    popup.setWebViewClient(new WebViewClient(){
     @Override public boolean shouldOverrideUrlLoading(WebView v,WebResourceRequest r){external(r.getUrl().toString());v.destroy();return true;}
    });
    ((WebView.WebViewTransport)m.obj).setWebView(popup);m.sendToTarget();return true;
   }
  });
  // Reiniciar pela tela inicial evita restaurar o iframe OCR sem seu estado JavaScript.
  web.loadUrl(HOME);
 }
 @Override public void onBackPressed(){if(web.canGoBack())web.goBack();else super.onBackPressed();}
}
