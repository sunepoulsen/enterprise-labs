<template>
  <div class="home p-grid p-justify-center">
    <div class="p-col-5">
      <img alt="Vue logo" src="@/assets/logo.png">
      <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>
    </div>
  </div>
</template>

<script lang="ts">
// @ is an alias to /src
import HelloWorld from '@/app/modules/home/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>
