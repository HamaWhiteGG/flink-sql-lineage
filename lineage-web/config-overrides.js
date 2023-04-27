const {
  override,
  disableEsLint,
  overrideDevServer,
  watchAll,
  useBabelRc,
} = require("customize-cra")
const path = require('path')

const stylus = () => config => {
  const stylusLoader = {
    test: /\.styl$/,
    include: [path.resolve(__dirname, 'src')],
    exclude: /node_modules/,
    sideEffects: true,
    use: [
      {
        loader: 'style-loader',
      },
      {
        loader: 'css-loader',
      },
      {
        loader: 'stylus-loader',
        options: {
          sourceMap: true,
        },
      },
    ],
  }
  const oneOf = config.module.rules.find(rule => rule.oneOf).oneOf
  oneOf.unshift(stylusLoader)
  return config
}

module.exports = {
  webpack: override(
    // usual webpack plugin
    disableEsLint(),
    stylus(),
    useBabelRc(), 
    config => {
      const babelLoader = {
        test: /\.jsx?/,
        exclude: /node_modules/,
        use: ["babel-loader"],
      }
      const oneOf = config.module.rules.find(rule => rule.oneOf).oneOf
      oneOf.unshift(babelLoader)
      return config
    }
  ),
  devServer: overrideDevServer(
    // dev server plugin
    watchAll(),
    () => {
      return  {
          proxy: {
            '*': {
              target: 'http://192.168.90.150:8194',
              logLevel:'debug',
              changeOrigin: true,
            },
          }
        }
    }
  )
};
