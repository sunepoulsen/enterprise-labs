<template>
    <div>
        This lab demonstrates how VUE renders different data types in its templates.
        <p/>
        Features:
        <ul>
            <li>Basic types</li>
            <li>Iteration over list</li>
            <li>Iteration over a filtered list</li>
        </ul>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'

@Component
export default class VueComponentRenderDoc extends Vue {
}
</script>

<style scoped>

</style>
