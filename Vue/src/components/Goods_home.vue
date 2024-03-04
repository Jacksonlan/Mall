<template>
     <div class="flex">
        <!-- 轮播图盒子 -->
        <div class="container">
            <!-- 存放轮播图片 -->
        <div class="roll_img" v-for="(img,index) in h.imgList" @mouseenter="Pause" @mouseleave="Roll"><img :src="img.src" alt="图片加载失败" class="size" v-show="h.n==index" /></div>
        <!-- 左右侧切换图 -->
        <a href="javascript:;" class="bow"><div class="roll_left" @click="silde('back')" @mouseenter="Pause" @mouseleave="Roll">&lt;</div></a>
        <a href="javascript:;" class="bow"><div class="roll_right" @click="silde('next')" @mouseenter="Pause" @mouseleave="Roll">&gt;</div></a>
        <!-- 底部图片定位 -->
        <div class="box-li">
           <li v-for="(item,i) in h.imgList" :class="h.n==i ? 'active' : '' " @mouseenter="Pause" @mouseleave="Roll" @click="Spot_li(i)"></li>
        </div>
    </div>
         <!-- 内容盒子 -->
         <div class="content">
            <div class="left" v-for="good in h.goods">
                <router-link :to="{path:'/Goods_detail',query:{good_id:good.good_id}}"  class="unify"> 
            <div class="left_img">
                <img :src="'https://picture.jacksonlan.top/pictures/'+good.picture" class="img" alt="图片加载失败" />
            </div>
            <div class="t">
                <span class="goodName">{{ good.introduce }}</span>
                <span class="price">￥{{good.lower_price}}起</span>
            </div>
            </router-link>
            </div>
    </div>
    </div>
</template>
<style src="@/assets/css/Goods_home.css" scoped></style>
<script setup>
import store from "@/Store"  
import { onMounted } from "vue";

const h=store.state.Goods_home

onMounted(()=>{
    Roll()
    store.commit("Goods_home/GetAllMessage")
})
const Pause=()=>{
    store.commit("Goods_home/Pause")
}
const Roll=()=>{
    store.commit("Goods_home/Roll")
}
const silde=(s)=>{
    store.commit("Goods_home/silde",s)
}
const Spot_li=(i)=>{
    store.commit("Goods_home/Spot_li",i)
}
</script>