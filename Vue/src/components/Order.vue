<template>
   <div class="box-outer" v-show="o.orders.length>0">
        <h1 class="title">我的订单</h1>
        <table class="orderTable">
            <colgroup> 
                <col width="50%" />
            </colgroup>
                 <!-- 顶部信息导航 -->
            <tr class="OrderLeader"><th v-for="li in o.lis ">{{ li.name }}</th></tr>
             <!-- 订单信息 -->
            <tr class="OrderMessage" v-for="order in o.orders">
                <td class="poi"><img :src="'https://picture.jacksonlan.top/pictures/'+order.picture" class="orderPic" />{{ order.introduce }}</td>
                <td>{{ order.count }}</td>
                <td>{{ order.order_time }}</td>
                <td>{{ order.business }}</td>
                <td>￥{{ parseFloat(order.price).toFixed(2) }}</td>
                <td>{{ order.state }}</td>
            </tr>
        </table>
    </div>
    <div class="OrderNull" v-show="o.orders.length===0">
        <img src="https://picture.jacksonlan.top/pictures/Order_null.png" />
        <h1>您还未有完成的订单!</h1>
    </div>
</template>
<style src="@/assets/css/Order.css" scoped></style>
<script setup>
import { onMounted } from 'vue';
import store from '../Store';

const o=store.state.Order

onMounted(()=>{
    GetData()
})
const GetData=()=>{
    store.dispatch("Order/Data")
}
</script>