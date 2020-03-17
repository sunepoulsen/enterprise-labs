<template>
  <div id="app">
    <Layout/>
  </div>
</template>

<script lang="ts">
// @ is an alias to /src
import Layout from '@/app/layout/Layout.vue'

export default {
  name: 'App',
  components: {
    Layout
  }
}
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
