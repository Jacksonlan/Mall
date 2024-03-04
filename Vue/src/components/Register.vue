<template>
    <div class="flex">
    <!-- 登录界面面板 -->
       <div class="box_table">
        <!-- 输入内容面板 -->
        <div class="input_table">
            <div class="login_table">
            <h1>注册</h1>
                <input type="text" class="account" placeholder="注册账号" v-model="register.account" maxlength="11" @blur="check_account"/>
                <p class="tip">{{ register.tip1 }}</p>
                <input type="password" class="password" placeholder="密码" v-model="register.password" maxlength="11" @blur="check_password"/>
                <p class="tip">{{ register.tip2 }}</p>
                <input type="password" class="password" placeholder="确认密码" v-model="register.repassword" maxlength="11" @blur="check_repassword" @keyup.enter="Register"/>
                <p class="tip">{{ register.tip3 }}</p>
                <input type="button" class="sub" value="注册" @click="Register"/>
            </div>
            <router-link to="/Login" class="to_login">&lt;已有账号去登录</router-link> 
        </div>
       </div>
   </div>
</template>
<style src="@/assets/css/Register.css" scoped></style>
<script setup>
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import api from '@/util/request.js'

const store=useStore()
const router=useRouter()
const register=store.state.Register

const check_account=()=>{
    store.commit("Register/check_account")
}
const check_password=()=>{
    store.commit("Register/check_password")
}
const check_repassword=()=>{
    store.commit("Register/check_repassword")
}
const Register=()=>{
    store.commit("Register/pass")
    if(register.passed){
        const url="/addUser"
        const data={
            username:register.account,
            password:register.password
        }
        api.post(url,data).then(res=>{
            console.log(res.data);
            if(res.data.code===200){
                store.commit("Register/Clear")
                alert("注册成功，正在跳转登录页面.....")
                router.replace('/Login')
            }else{
                alert("注册失败,此账号已被注册！")
                router.go(0)
            }
        }).catch((err)=>{
            console.log(err);
            alert("注册失败,此账号已被注册！")
                router.go(0)
        })
        
                
    }
    
}
</script>