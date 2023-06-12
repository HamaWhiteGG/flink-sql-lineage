import React, { useState, useEffect, useMemo } from 'react'
import { Link } from 'react-router-dom'
import { Tree, Dropdown, Tag } from 'antd'
import { MoreOutlined, DeleteOutlined, TableOutlined, DatabaseOutlined, FunctionOutlined, FolderViewOutlined } from '@ant-design/icons'


// It's just a simple demo. You can use tree map to optimize update perf.
const updateTreeData = (list, key, children) => 
  list.map((node) => {
    if (node.key === key) {
      return {
        ...node,
        children,
      };
    }
    if (node.children) {
      return {
        ...node,
        children: updateTreeData(node.children, key, children),
      };
    }
    return node;
  });

const tableItems = [
  {
    key: 'setDefault',
    label: (<span>set default</span>),
  },
  {
    key: 'createTable',
    label: (<span>create table</span>),
  },
]

const functionItems = [
  {
    key: 'setDefault',
    label: (<span>set default</span>),
  },
  {
    key: 'createFunction',
    label: (<span>create function</span>),
  },
]

const Cm = (props) => {
  const {
    catalogDetail,
    databaseList=[],
    databaseFunList,
    databaseTableList,
    type,
    getChildren,
    databaseName,
    itemId,
  } = props
  
  const initTreeData = useMemo(() => {
    return databaseList?.map(t => {
      return {
        title: t,
        key: t,
        icon: <DatabaseOutlined />,
        default: true,
        oparations: 'more',
        type: 'database'
      }
    })
  }, [databaseList])

  const initExpandedKeys = useMemo(() => [databaseName || catalogDetail.defaultDatabase], [databaseName, catalogDetail.defaultDatabase])
  const initSelectedKeys = useMemo(() => [itemId], [itemId])
  const [treeData, setTreeData] = useState([])
  const [expandedKeys, setExpandedKeys] = useState([])
  const [selectedKeys, setSelectedKeys] = useState([])
  
  useEffect(() => {
    setTreeData(initTreeData)
  }, [databaseList])

  useEffect(() => {
    setExpandedKeys(initExpandedKeys)
  }, databaseName)

  useEffect(() => {
    setSelectedKeys(initSelectedKeys)
  }, databaseName)
    
  const onLoadData = ({ key, children }) => {
    return getChildren(key)
    .then((resolve=[], reject) => {
      if (children) {
        return;
      }
      setTimeout(() => {
        setTreeData((origin) =>
          updateTreeData(origin, key, 
            resolve.map((t, i) => {
              return type === 'table' ? 
                {title: t.tableName, key: t.tableName, oparations: 'delete',type: 'table', icon: <span style={{verticalAlign: 'sub'}}>{iconMap['table']}</span>, isLeaf: true}
                :
                {title: t.functionName, key: t.functionId, oparations: 'delete', type: 'function', icon: <span style={{verticalAlign: 'sub'}}>{iconMap['function']}</span>, isLeaf: true}
            })
          ),
        );
      }, 1000)
    })
  }

  const getOparation = node =>{
    const items = type === 'table' ? tableItems : functionItems
    const optionMap = {
      more: <Dropdown
        menu={{
          items,
        }}
        trigger={['click']}
      >
        <MoreOutlined />
      </Dropdown>,
      delete: <DeleteOutlined onClick={(e) => {console.log({...node})}} />,
    }
    return optionMap[`${node.oparations}`]
  }

  const onExpand = (expandedKeysValue) => {
    setExpandedKeys(expandedKeysValue);
  }

  const onSelect = (selectedKeysValue, info) => {
    setSelectedKeys(selectedKeysValue);
  }

  const iconMap = {
    database: <DatabaseOutlined />,
    table: <TableOutlined />,
    view: <FolderViewOutlined />,
    function: <FunctionOutlined />
  }
  
  return (
    <div className='mt16 left-tree'>
      <Tree
        showIcon
        blockNode
        expandedKeys={expandedKeys}
        onExpand={onExpand}
        onSelect={onSelect}
        selectedKeys={selectedKeys}
        loadData={(node) => onLoadData(node, databaseFunList)}
        treeData={treeData}
        // icon={node => <span className='mt4 mb4' style={{verticalAlign: 'baseline'}}>{iconMap[`${node.type}`]}</span>}
        titleRender={node => (
          node.type !== 'database' ? 
          <Link to={`/catalog/${catalogDetail.catalogId}/${catalogDetail.defaultDatabase}/${type}/${node.key}`}>
            <div className='FBH FBJ mt4 mb4' style={{display: 'inline-flex'}}>
              <div className='omit' style={{width: 175}}>
                {node.title} {node.default && <Tag>default</Tag>}
              </div>
              <div>
                {getOparation(node)}
              </div>
            </div>
          </Link>
          : 
          <div className='FBH FBJ' style={{display: 'inline-flex'}}>
            <div style={{width: 200}}>
              {node.title} {node.default && <Tag>default</Tag>}
            </div>
            <div>
              {getOparation(node)}
            </div>
          </div>
        )}
      />
    </div>
  )
}
export default Cm