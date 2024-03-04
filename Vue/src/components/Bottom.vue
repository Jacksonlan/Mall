<template>
 <div class="table">
        <ul>
            <li v-for="(li,index) in b.lis"><a :href="li.href" class="tx">{{ li.name }}</a><span class="s" v-if="index<b.lis.length-1">|</span></li>
        </ul>
        <p class="p" v-for="p in b.ps">{{ p }}</p>
        <a target="_blank" :href="query.href" v-for="query in b.querys" class="police"><img :src="query.img" class="ba"/><span class="pl">{{ query.content }}</span></a>
        <p class="p">违者将依法追究法律责任</p>
    </div>
</template>
<script setup>
import { useStore } from 'vuex';

const store=useStore()
const b=store.state.Bottom
</script>
<style src="@/assets/css/Bottom.css" scoped></style>