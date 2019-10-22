import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

declare global {
  interface Window { vue: any }
}
Vue.config.productionTip = false

var myVue = new Vue({
  data: {
  },

  router,
  store,
  render: h => h(App)
}).$mount('#app')

window.vue = myVue
