module.exports = {
  // filenameHashing: false,
  publicPath: '',
  outputDir: '../webapp/dist',
  indexPath: 'index.html',
  assetsDir: '../myAssets',
  chainWebpack: config => {
    config.plugins.delete('preload')
    config.plugins.delete('prefetch')
    config
      .plugin('html')
      .tap(args => {
        args[0].template = 'public/index.js'
        args[0].inject = false
        args[0].cache = false
        args[0].minify = false
        args[0].filename = 'index-1.html'
        return args
      })
  }
}
