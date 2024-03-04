<template>
    <div class="AddSuccess">
        <div class="MessageTitle">
            <img src="https://picture.jacksonlan.top/pictures/笑脸.png" class="Logo" />
            <h1>添加到购物车成功!</h1>
        </div>
        <div class="routerTip">
            {{ second }}秒后跳转购物车界面，或<router-link @click="rightNow">点击此处</router-link>跳转
        </div>
    </div>
</template>
<style src="../assets/css/AddSuccess.css" scoped></style>
<script setup>
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';

const router=useRouter()
const second=ref(3)

onMounted(()=>{
    count()
})
const count=()=>{
    const countdown=setInterval(()=>{
        second.value--
        if(second.value===0){
            clearInterval(countdown)
            router.push("/Shopping")
        }
    },1000)    
}
const rightNow=()=>{
    second.value=1
}
</script>