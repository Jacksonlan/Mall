<template>
 <div class="flex">
        <!-- 商品事物以及介绍 -->
        <div class="goods">
        <!-- 左下方图片功能 -->
        <div class="picture">  
            <div class="picture_change">
                 <li :class="pic!=ix?'p1':'p1_now'" v-for="(img,ix) in d.detail" @click="current(ix)"><img :src="'https://picture.jacksonlan.top/pictures/'+img.picture" class="i" /></li>
             </div>
        <!-- 商品图片 -->
       <div class="goods_picture" v-show="pic==index" v-for="(ims,index) in d.detail">
        <img :src="'https://picture.jacksonlan.top/pictures/'+ims.picture" class="img1" alt="图片加载失败" />
       </div>
    </div>
       <!-- 商品介绍 -->
       <div class="message">
        <h3 v-for="(ic,i) in d.detail" v-show="num===i">{{ ic.introduce }}</h3>
            <!-- 价格信息 -->
            <div class="price_message">
            <span class="advise">建议价格</span>
            <span class="price" v-for="(p,i) in d.detail" v-show="num===i">￥{{ parseFloat(p.price).toFixed(2)  }}</span>
            <p class="discount" v-for="(s,i) in d.detail" v-show="num===i">月销:{{ s.sell }}</p>
            </div>
            <!-- 商品类别信息 -->
            <div class="message_class">
                <p class="tip">由某某发货, 供应商提供售后服务. 23:00前下单,预计明天(07月27日)送达</p>
                <span class="kinds">选择种类</span>
                <div :class="num==i ? 'selected' : 'kind'" v-for="(style,i) in d.detail" @click="select(i)">{{ style.load}}</div>
                <div class="server">
                <span class="service">服务支持</span>
                <span class="support">7天无理由退款   7天价保  商家赠送运险费</span>
                </div>
            </div>
            <div class="bottom1">
            <span class="ql">数量:</span>
            <input type="button" class="sub" value="-" @click="sub" />
            <input type="text" class="count" v-model="count"/>
            <input type="button" class="add" value="+" @click="add"/>
            <span class="no" v-for="(s,i) in d.detail" v-show="num===i">{{count>s.stock?'无货':'有货'}}</span>
            </div>
            <input type="button" class="Buying" value="立即购买" />
            <input type="button" class="shopping_add"  value="加入购物车" @click="AddCar(d.detail[num])" />
        </div>
        </div>
        <!-- 商品评价信息 -->
        <div>
            <!-- 顶部导航 -->
        <div class="top">
            <h3 class="comment">商品评价</h3>
        </div>
        <Comment />
    </div>
    </div>
</template>
<style src="@/assets/css/Goods_detail.css" scoped></style>
<script setup>
import Comment from '@/components/Comment.vue'
import store from '../Store'
import api from "@/util/request.js"
import { onMounted, ref } from 'vue';
import {useRoute, useRouter} from 'vue-router'

const route=useRoute()
const router=useRouter()
const d=store.state.Detail
const pic=ref(0)
const num=ref(0)
const count=ref(1)

onMounted(()=>{
   const id=route.query.good_id
   store.commit("Detail/GetDetail",id)
})
const current=(i)=>{
    pic.value=i
}
const select=(i)=>{
    num.value=i
}
const add=()=>{
    count.value++
}
const sub=()=>{
    if(count.value>1){
        count.value--;
    }
}
const AddCar=(p)=>{
    if(sessionStorage.getItem("uid")!=null){
        if(document.querySelector(".no").textContent==='有货'){
            let url="/addCar"
            let data={
                good_id:p.good_id,
                uid:sessionStorage.getItem("uid"),
                current_load:p.load,
                current_count:count.value,
                current_price:p.price,
                stock:p.stock
            }
        api.post(url,data).then(res=>{
            if(res.data.code===200){
                router.push("/AddSuccess")
            }
        })
        } 
    }else{
        alert("请登录后再添加商品!")
        router.push("/login")
    }   
}
</script>