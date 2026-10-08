# Dúvidas Rápidas — APK offline

Este projeto contém somente o aplicativo: dúvidas rápidas e guia da OCR. Não contém painel, servidor, votação, envio de dados ou exigência de URL publicada. O conteúdo está em android/app/src/main/assets/index.html. Não é um APK compilado.

## Gerar pelo GitHub
1. Extraia o ZIP.
2. Crie um repositório privado no GitHub, com README.
3. Add file > Upload files: envie a pasta android na raiz e confirme o commit.
4. Add file > Create new file: nome .github/workflows/apk.yml.
5. Abra o arquivo de mesmo nome do pacote extraído no Bloco de Notas, copie todo o conteúdo para o GitHub e confirme na branch main.
6. Actions > Gerar APK offline > Run workflow > Run workflow. Nenhum endereço é solicitado.
7. Quando terminar com sucesso, abra a execução e baixe o artefato Duvidas-Rapidas-APK-offline.
8. Extraia o artefato: app-debug.apk.
9. Instale em um aparelho autorizado para homologação. O launcher/MDM deve permitir o pacote br.com.suporte.duvidas.

Esse APK de depuração é para teste. Para distribuir aos 500 aparelhos, gere APK release assinado no Android Studio usando uma chave persistente da organização: Build > Generate Signed App Bundle / APK > APK. Preserve a chave para futuras atualizações. O APK de teste gerado pelo GitHub pode receber uma chave debug diferente em outra execução: desinstalar/reinstalar pode ser necessário para os testes. Não use esse processo de assinatura temporária na frota.

## Funcionamento
Conteúdo e ilustrações incluídos no APK; dúvidas e cronômetros funcionam sem conexão. A abertura do WhatsApp exige app/navegador permitido e rede para conversar. Sem painel e sem “Isso resolveu?”. Os dois cronômetros de 150 segundos não podem ser pulados pela interface.

Android mínimo: 8.0; WebView atualizado e com suporte a srcdoc. Ao recriar a Activity, o app volta à tela inicial e o procedimento precisa ser reiniciado. Testar em aparelhos reais, incluindo rotação, voltar, cronômetros, WhatsApp e modo avião. O APK não foi compilado nem testado em aparelhos neste ambiente.

Para atualizar conteúdo, altere index.html e aumente versionCode antes de gerar novo APK de produção com a mesma assinatura. Não é necessário servidor nem executar Python.
