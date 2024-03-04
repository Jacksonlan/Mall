<template>
      <!-- 顶部导航栏 -->
   <div class="top_direction">
    <router-link to="/goods_home" class="toHome">
    <img src="https://picture.jacksonlan.top/pictures/商城.png" alt="图片加载失败" class="logoImg" />ShopStore
    </router-link>
    <router-link to="/goods_home" :class="pathname==='/goods_home'?'br':'home'">商城首页</router-link>
    <span class='top_li'  v-for="title in top.titles">
    <a :class="pathname===title.router?'b2r':'a'" @click="check(title.router)">{{ title.name }}</a>
    </span>
    <span class="top_li" v-show="top.Name!==undefined">亲爱的:{{ top.Name }}
        <router-link to="/" class="quit" @click="quit">退出登录</router-link>
        <router-link to="/" class="quit" @click="DeleteUser">注销账号</router-link>
    </span>
    <span class="top_li" v-show="top.Name===undefined"><router-link to="/Login" class="a">登录</router-link></span> 
   </div>
</template>
<style src="@/assets/css/Top.css" scoped></style>
<script setup>
import { onMounted,ref } from 'vue';
import {useStore} from 'vuex'
import { useRouter } from 'vue-router';

const store=useStore()
const router=useRouter()
const top=store.state.Top
const pathname=ref(router.currentRoute.value.path)

onMounted(()=>{
    store.commit("Top/SetSession")
    // 事件渲染监听点击后获取当前路径
    router.afterEach(()=>{
    // 将当前的路径赋给全局变量
        pathname.value=router.currentRoute.value.path
    }) 
})

const quit=()=>{
    store.commit("Top/quit");
}
const DeleteUser=()=>{
    store.dispatch('Top/Delete')
}

const check=(r)=>{
    if(sessionStorage.getItem("username")){
        router.push(r)
    }else{
        alert('请先登录！')
        router.push('/Login')
    }
}
</script>