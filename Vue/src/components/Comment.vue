<template>
 <!-- 内容盒子 -->
 <div class="Input">
    <textarea placeholder="请输入评价" class="Text" v-model="c.comment" />
    <button class="subComment" @click="Submit">发送</button>
 </div>
 <div class="content" v-for="(content,index) in c.contents">
                <!-- 头像框盒子 -->
                <div class="sculpture">
                    <img :src="'https://picture.jacksonlan.top/pictures/'+content.head" class="sculpture_img" alt="图片加载失败" />
                </div>
                 <!-- 信息 -->
                 <div class="news">
                    <a href="#" class="sculpture_a">{{ content.username }}</a>
                    <p class="time">{{ content.time }}</p>
                </div>
                <!-- 中间内容信息 -->
                <div class="text_content">
                    <p>{{ content.content }}</p>
                </div>
                <!-- 底部功能 -->
         <div class="bottom">
            <span class="a" @click="Like(index)"><img :src="content.action==='liked'? c.liked:c.like" class="img"/>{{ content.like }}</span>
            <span class="a" @click="Dislike(index)"><img :src="content.action==='disliked'? c.disliked:c.dislike" class="img"/>{{ content.dislike }}</span>
        </div>
 </div>
</template>
<style src="@/assets/css/Comment.css" scoped></style>
<script setup>
import store from '@/Store/index.js'
import { onMounted } from 'vue';
import {useRouter} from "vue-router"

const c=store.state.Comment
const route=useRouter()

onMounted(()=>{
store.commit("Comment/GetComments")
})
const Submit=()=>{
    if(sessionStorage.getItem("uid")!=null){
        store.commit("Comment/Submit")
        route.go(0)
    }else{
        alert("请先登录再进行评价!")
        this.$router.push("/login")
    }
}
const Like=(id)=>{
    store.commit("Comment/Like",id)
}
const Dislike=(id)=>{
    store.commit("Comment/Dislike",id)
}
</script>