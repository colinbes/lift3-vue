// see https://github.com/jantimon/html-webpack-plugin#writing-your-own-templates
module.exports = function (templateParams) {
  let index = 0
  let html = '<div>\n'

  const cssFiles = templateParams.htmlWebpackPlugin.files.css
  const jsFiles = templateParams.htmlWebpackPlugin.files.js

  html += '<div id="app"></div>\n'
  for (index = 0; index < cssFiles.length; index++) {
    html += `<link href="${cssFiles[index].substr(1)}" rel=stylesheet>\n`
  }
  for (index = 0; index < jsFiles.length; index++) {
    html += `<script src="${jsFiles[index].substr(1)}"></script>\n`
  }
  html += '</div>'
  return html
}
