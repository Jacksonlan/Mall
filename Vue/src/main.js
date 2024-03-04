import { createApp } from 'vue'
import App from './App.vue'
import store from './Store'
import router from '../src/router/router'


const app=createApp(App)
app.use(router)
app.use(store)
app.mount('#app')