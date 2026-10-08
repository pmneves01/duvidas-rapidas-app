# Dúvidas Rápidas

Aplicativo Android offline com dúvidas rápidas e guia de instalação da OCR. Sem painel, avaliações ou servidor. Os cronômetros de 150 segundos não podem ser pulados pela interface.

## Baixar APK
Abra Actions → Gerar APK offline → execução concluída → Artifacts → Duvidas-Rapidas-APK-offline. Extraia o ZIP e instale app-debug.apk para homologação.

A compilação inicia em cada envio à main e também por Run workflow. O conteúdo está em android/app/src/main/assets/index.html.

Android mínimo: 8.0. WhatsApp exige rede. Valide em aparelhos antes de distribuir. Para produção, gere APK release assinado com chave persistente da organização e distribua pelo launcher/MDM. Pacote: br.com.suporte.duvidas.
