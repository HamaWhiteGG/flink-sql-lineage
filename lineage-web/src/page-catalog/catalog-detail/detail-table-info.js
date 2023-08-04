import React,{useState, useEffect} from 'react'
import { useParams, useOutletContext } from 'react-router-dom'
import { Descriptions,  Button, Collapse, Tabs, message} from 'antd'
import { Base64 } from 'js-base64'
import io from '@common/io-context'
import OverView from './table-info-overview'
import Ddl from './table-info-ddl'
import Lineage from './table-info-lineage'
import ModalAddTable from './modal-add-table'

const Cm = () => {
  const {id: catalogId, itemId: tableName} = useParams()
  const { catalogDetail, databaseName, itemId } = useOutletContext()
  const [activeKey, setActiveKey] = useState('1')
  const { catalogName, catalogType, defaultDatabase, pluginId, pluginName } = catalogDetail
  const [addTableVisible, setAddTableVisible] = useState(false)
  const [value, setValue] = useState(null)

  const getTableInfos = async () => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases/${databaseName}/tables/${tableName}/ddl`)
      setValue(Base64.decode(res))
    } catch (error) {
      message.error(error)
    }
  }

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

  const ModalAddTableProps = {
    type: 'edit',
    visible: addTableVisible,
    curDatabase: defaultDatabase,
    databaseList: [],
    catalogDetail,
    // onLoadData,
    formValues: {
      database: defaultDatabase,
      value
    },
    switchVisible: setAddTableVisible,
    onCancel: () => setAddTableVisible(false),
  }

  useEffect(() => {
    setActiveKey('1')
  }, [databaseName, itemId])

  useEffect(() => {
    getTableInfos()
  }, [tableName])

  return (
    <div className='right-info-box'>
      <div className='white-bg p16'>
        <Descriptions title={itemId} extra={<Button type="primary" onClick={() => {setAddTableVisible(true)}}>Edit</Button>}>
          <Descriptions.Item label="Catalog Name">{catalogName}</Descriptions.Item>
          <Descriptions.Item label="Catalog Type">{catalogType}</Descriptions.Item>
          <Descriptions.Item label="Database">{defaultDatabase}</Descriptions.Item>
          <Descriptions.Item label="Plugin">{pluginName}</Descriptions.Item>
        </Descriptions>
      </div>
      <Tabs className='gray-bg' tabBarStyle={{background: '#fff', paddingLeft: '16px', paddingRight: '16px'}} activeKey={activeKey} items={items} onChange={onChange} />
      <ModalAddTable {...ModalAddTableProps} />
    </div>
  )
}
export default Cm