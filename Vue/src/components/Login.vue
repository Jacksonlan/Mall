<template>
<div class="flex">
    <!-- 登录界面面板 -->
       <div class="box_table">
        <!-- 输入内容面板 -->
            <div class="login_table">
            <h1>登录</h1>
                <input type="text" class="account" placeholder="账号" v-model="login.acc" maxlength="11" @blur="checked_ac"/>
                <p class="message">{{ login.message }}</p>
                <input type="password" class="password" placeholder="密码" v-model="login.pss" @blur="checked_ps" @keyup.enter="submit()"/>
                <p class="message">{{ login.tip }}</p>
                <input type="button" class="sub" id="submit" value="登录" @click="submit()" />
                <tr class="to_register">
                <router-link to="/register">注册新账号</router-link>
                </tr>
        </div>
       </div>
   </div>
   <Bottom />
</template>
<style src="@/assets/css/Login.css" scoped></style>
<script setup>
import api from '@/util/request.js'
import {useRouter} from 'vue-router'
import {useStore} from 'vuex'
import Bottom from './Bottom.vue'

const router=useRouter()
const store=useStore()
const login=store.state.Login

const checked_ac=()=>{
    store.commit("Login/checked_ac")
}
const checked_ps=()=>{
    store.commit("Login/checked_ps")
}

const submit=()=>{
if(login.message==="" && login.tip===""){
    const url="/login"
    const params={
        username:login.acc,
        password:login.pss
    }
    api.get(url,params).then(res=>{
        if(res.data.code===200){
            sessionStorage.setItem("username",res.data.data.username)
            sessionStorage.setItem("uid",res.data.data.uid)
            store.commit("Login/Clear")
            alert("登录成功!")
            router.replace('goods_home')
        }else{

            alert("您输入的账号不存在!")
            router.go(0)
        } 
    })
}
}
</script>
