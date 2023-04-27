import _ from 'lodash'

export const getInit = (mock, postfix = '') => {
  const {nodes = [], links = [], id} = _.cloneDeep(mock)
  const taskObj = {}
  const taskNodes = links
    .filter(n => !!n.task)
    .forEach(t => {
      taskObj[`${t.relU}-${t.relV}`] = _.cloneDeep(t.task)
    })
  
  let NodeDownIsTableMap = []
  let obj = {}
  const newlinks = _.cloneDeep(links.filter(t => !t.u && !t.v))
  // const NodeDownIsTableMap = {}
  newlinks.forEach(t => {
    const sourceNode = _.cloneDeep(nodes.find(n => n.id === t.relU))
    const targetNode = _.cloneDeep(nodes.find(n => n.id === t.relV))
    // sourceNode.DownIsTable = true
    let DownIsTable = true
    let curNode = {}
   
    if (targetNode.type === 2) {
      sourceNode.DownIsTable = true
      DownIsTable = true
    } else {
      sourceNode.DownIsTable = false
      DownIsTable = false
    }
    curNode = nodes.find(n => n.id === sourceNode.id) 
    curNode.DownIsTable = DownIsTable
    
    if (!NodeDownIsTableMap[sourceNode.id]) {
      NodeDownIsTableMap[sourceNode.id] = []
    }
    NodeDownIsTableMap[sourceNode.id].push(DownIsTable)

    if (!NodeDownIsTableMap[targetNode.id]) {
      NodeDownIsTableMap[targetNode.id] = []
    }
    NodeDownIsTableMap[targetNode.id].push(true)

  })
  NodeDownIsTableMap = NodeDownIsTableMap.map((t, key) => {
    const i = t.findIndex(t => t === false)
    const curNode = nodes.find(n => n.id === `${key}`)
    if (i > -1) {
      curNode.DownIsTable = false
    } else {
      curNode.DownIsTable = true
    }
    
    return t
  })
  return {
    nodes: nodes.map(t => {
      t.id = `${t.id}${postfix}`
      t.isFold = t.type === 2 ? (t.isFold || true) : true
      t.scopeType = '3'
      t.isPrimary = false

      if (t.id === `${id}${postfix}`) {
        t.isPrimary = true
      }
      // 获取node上下游标识
      links.forEach(link => {
        if (link.relU === `${id}${postfix}` && link.relV === t.id) {
          t.scopeType = '2'
        }
        if (link.relV === `${id}${postfix}` && link.relU === t.id) {
          t.scopeType = '1'
        }
      })
      return t
    }),
    links: links.map(t => {
      t.relU = `${t.relU}${postfix}`
      t.relV = `${t.relV}${postfix}`
      if (t.u) {
        t.u = `${t.u}`
      }
      if (t.v) {
        t.v = `${t.v}`
      }
      if (taskObj[`${t.relU}-${t.relV}`]) {
        t.task = taskObj[`${t.relU}-${t.relV}`]
      }
     
      return t
    }),
  }
}

export const getShrinkDownChildren = (mock, tableId) => {
  const children = {
    nodes: [],
    links: [],
  }
  const {nodes = [], links = []} = mock
  links.forEach(relation => {
    if (relation.relU !== tableId) {
      return
    }

    children.links.push(relation)
    const {relV} = relation
    const table = nodes.find(t => t.id === relV)

    if (children.nodes.some(t => t.id === relV)) {
      return
    }

    if (table) {
      children.nodes.push(table)
    }
  })

  return children
}
export const getShrinkUpChildren = (mock, tableId) => {
  const children = {
    nodes: [],
    links: [],
  }
  const {nodes = [], links = []} = mock
  links.forEach(relation => {
    if (relation.relV !== tableId) {
      return
    }

    children.links.push(relation)
    const relU = relation.relU
    const table = nodes.find(t => t.id === relU)

    if (children.nodes.some(t => t.id === relU)) {
      return
    }

    if (table) {
      children.nodes.push(table)
    }
  })

  return children
}
