import React,{useState, useEffect} from 'react'
import { useParams, useOutletContext } from 'react-router-dom'
import { Descriptions,  Button, Collapse, Tabs, message} from 'antd'
import OverView from './table-info-overview'
import Ddl from './table-info-ddl'
import Lineage from './table-info-lineage'

const Cm = () => {
  const {id: catalogId, itemId: tableName} = useParams()
  const { catalogDetail, databaseName, itemId } = useOutletContext()
  const [activeKey, setActiveKey] = useState('1')
  const { catalogName, catalogType, defaultDatabase, pluginId } = catalogDetail

  const onChange = (key) => {
    console.log(key);
    setActiveKey(key)
  }
 
  const infoProps = {
    catalogId,
    defaultDatabase,
    tableName,
    databaseName,
  }

  const items = [
    {
      key: '1',
      label: `Overview`,
      children: <OverView {...infoProps} />,
    },
    {
      key: 'ddl',
      label: `DDL`,
      children: <Ddl {...infoProps} />,
    },
    {
      key: 'lineage',
      label: `Lineage`,
      children: <Lineage {...infoProps} />,
    },
  ]

  useEffect(() => {
    setActiveKey('1')
  }, [databaseName, itemId])

  return (
    <div className='right-info-box'>
      <div className='white-bg p16'>
        <Descriptions title={itemId} extra={<Button type="primary">Edit</Button>}>
          <Descriptions.Item label="Catalog Name">{catalogName}</Descriptions.Item>
          <Descriptions.Item label="Catalog Type">{catalogType}</Descriptions.Item>
          <Descriptions.Item label="Database">{defaultDatabase}</Descriptions.Item>
          <Descriptions.Item label="Plugin">{pluginId}</Descriptions.Item>
        </Descriptions>
      </div>
      <Tabs className='gray-bg' tabBarStyle={{background: '#fff', paddingLeft: '16px', paddingRight: '16px'}} activeKey={activeKey} items={items} onChange={onChange} />
    </div>
  )
}
export default Cm