<template>
    <div id="app">
        <div class="p-grid nested-grid">
            <div class="p-col-12">
                <LayoutHeader/>
            </div>
            <div class="p-col-12">
                <div class="p-grid">
                    <div class="p-col-2">
                        <layout-navigator/>
                    </div>
                    <div class="p-col-10">
                        <router-view/>
                    </div>
                </div>
            </div>
            <div class="p-col-12">
                <LayoutFooter/>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
// @ is an alias to /src
import LayoutHeader from './components/LayoutHeader.vue'
import LayoutNavigator from './components/LayoutNavigator.vue'
import LayoutFooter from './components/LayoutFooter.vue'

export default {
  name: 'Layout',
  components: {
    LayoutHeader,
    LayoutNavigator,
    LayoutFooter
  }
}
</script>

<style scoped>

</style>
